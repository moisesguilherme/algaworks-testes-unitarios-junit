package com.algaworks.junit.blog.negocio;

import com.algaworks.junit.blog.modelo.Editor;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CadastroEditorTest {

    static CadastroEditor cadastroEditor;

    static ArmazenamentoEditorFixoEmMemoria armazenamentoEditor;

    Editor editor;

    @BeforeAll
    static void beforeAll() {
        armazenamentoEditor = new ArmazenamentoEditorFixoEmMemoria();
        cadastroEditor = new CadastroEditor(
                armazenamentoEditor,
                new GerenciadorEnvioEmail() {
                    @Override
                    void enviarEmail(Mensagem mensagem){
                        System.out.println("Enviando mensagem para: " + mensagem.getDestinatario());

                    }
                }
        );
    }

    @BeforeEach
    void BeforeEach() {
        editor = new Editor(null, "Moises", "moises@gmail.com", BigDecimal.TEN, true);
    }

    @Test
    public void Dado_um_editor_valido_Quando_Criar_Entao_deve_retornar_um_id_de_cadastro() {
        Editor editorSalvo = cadastroEditor.criar(editor);
        assertEquals(1L, editorSalvo.getId());
        assertTrue(armazenamentoEditor.chamouSalvar);
    }

    @Test
    public void Dado_um_editor_null_Quando_cridar_Entao_deve_retornar_exception() {
        assertThrows(NullPointerException.class, () -> cadastroEditor.criar(null));
        assertFalse(armazenamentoEditor.chamouSalvar);
    }

}
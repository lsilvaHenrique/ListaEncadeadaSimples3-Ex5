package view;

import controller.CadastroController;

public class Principal {
    public static void main(String[] args) {
        CadastroController.novoCadastro(41, 60, 8000.00);
        CadastroController.novoCadastro(31, 40, 5000.00);
        CadastroController.novoCadastro(21, 30, 3000.00);
    }
}

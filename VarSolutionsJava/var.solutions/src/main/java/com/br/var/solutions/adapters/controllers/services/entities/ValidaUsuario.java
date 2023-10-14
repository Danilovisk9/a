package com.br.var.solutions.adapters.controllers.services.entities;

public class ValidaUsuario {

    public enum validaUser {
        USER_1("var", "12345678"),
        USER_2("danilo.dias", "Teste01"),
        USER_3("aluno_var", "senha1234");

        private String usuario;
        private String senha;

        validaUser(String username, String password) {
            this.usuario = username;
            this.senha = password;
        }

        public String getUsuario() {
            return usuario;
        }

        public String getSenha() {
            return senha;
        }
    }

    public static boolean validaUsuario(String username, String password) {
        for (validaUser validaUser : validaUser.values()) {
            if (validaUser.getUsuario().equalsIgnoreCase(username) && validaUser.getSenha().equals(password))
                return true;
        }
        return false;
    }

    public static String returnPassword(String username) {
        for (validaUser validaUser : validaUser.values()){
            if (validaUser.getUsuario().equalsIgnoreCase(username)){
                return validaUser.getSenha();
            }
        }
        return null;
    }

    public static String returnUsername(String username){
        for(validaUser validaUser : validaUser.values()){
            if (validaUser.getUsuario().equalsIgnoreCase(username)){
                return validaUser.getUsuario();
            }
        }
        return null;
    }

}


package com.example.examensistemadecalificaciones;

public class Usuarios {

        private String ced;
        private String correo;
        private String id;
        private String materia;
        private String nombre;
        private String nota1;
        private String nota2;
        private String password;
        private String total;

        public Usuarios(){

        }

        public Usuarios(String correo, String password) {
            this.correo = correo;
            this.password = password;
        }

    public Usuarios(String nota1, String nota2, String total) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.total = total;
    }

    public Usuarios(String ced, String correo, String id, String materia, String nombre, String nota1, String nota2, String password, String total) {
        this.ced = ced;
        this.correo = correo;
        this.id = id;
        this.materia = materia;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.password = password;
        this.total = total;
    }

        public String getCed() {
            return ced;
        }

        public void setCed(String ced) {
            this.ced = ced;
        }

        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {
            this.correo = correo;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMateria() {
            return materia;
        }

        public void setMateria(String materia) {
            this.materia = materia;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getNota1() {
            return nota1;
        }

        public void setNota1(String nota1) {
            this.nota1 = nota1;
        }

        public String getNota2() {
            return nota2;
        }

        public void setNota2(String nota2) {
            this.nota2 = nota2;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

    }

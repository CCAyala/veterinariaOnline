package com.example.veterinariaf.entity;

import jakarta.persistence.*;



    @Entity
    @Table(name = "administrador")
    public class administrador {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(nullable = false,length = 250)
        private String nombre_completo;
        @Column(nullable = false)
        private int cedula;
        @Column(nullable = false,length = 10)
        private String celular;
        @Column(nullable = true, length = 200)
        private String email;

        public administrador() {
        }

        public administrador(int id, String nombre_completo, int cedula, String celular, String email) {
            this.id = id;
            this.nombre_completo = nombre_completo;
            this.cedula = cedula;
            this.celular = celular;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre_completo() {
            return nombre_completo;
        }

        public void setNombre_completo(String nombre_completo) {
            this.nombre_completo = nombre_completo;
        }

        public int getCedula() {
            return cedula;
        }

        public void setCedula(int cedula) {
            this.cedula = cedula;
        }

        public String getCelular() {
            return celular;
        }

        public void setCelular(String celular) {
            this.celular = celular;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

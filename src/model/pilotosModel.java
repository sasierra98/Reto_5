package model;

    public class pilotosModel {

        escuderiaModel escuderiamodel = new escuderiaModel();

        private int codigoPiloto;
        private String nombre;
        private float millasRecorridas;
        private int combustibleUsado;
        private int codigoEscuderia_fk = escuderiamodel.getEscuderiaId();

        public pilotosModel(){}

        public pilotosModel(String nombre){
            this.nombre = nombre;
        }

        public pilotosModel(int codigoPiloto, String nombre, float millasRecorridas,
                            int combustibleUsado, int codigoEscuderia_fk) {

            this.codigoPiloto = codigoPiloto;
            this.nombre = nombre;
            this.millasRecorridas = millasRecorridas;
            this.combustibleUsado = combustibleUsado;
        }

        public void setCodigoPiloto(int codigoPiloto) {
            this.codigoPiloto = codigoPiloto;
        }

        public int getCodigoPiloto() {
            return codigoPiloto;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setMillasRecorridas(int millasRecorridas) {
            this.millasRecorridas = millasRecorridas;
        }

        public float getMillasRecorridas() {
            return millasRecorridas;
        }

        public void setCombustibleUsado(int combustibleUsado) {
            this.combustibleUsado = combustibleUsado;
        }

        public int getCombustibleUsado() {
            return combustibleUsado;
        }

        public void setCodigoEscuderia_fk(int codigoEscuderia_fk) {
            this.codigoEscuderia_fk = codigoEscuderia_fk;
        }

        public int getCodigoEscuderia_fk() {
            return codigoEscuderia_fk;
        }

        public Object[] toArray(){
            Object[] data = {codigoPiloto, nombre, combustibleUsado, millasRecorridas, codigoEscuderia_fk};
            return data;
        }
    }


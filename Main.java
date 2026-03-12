public static void main(String[] args) {
        BitacoraStack bitacora = new BitacoraStack();

        // 1. Registro de eventos
        bitacora.registrar("Motor de estribor encendido");
        bitacora.registrar("Velocidad warp alcanzada");
        bitacora.registrar("Señal de comunicación estable");
        bitacora.registrar("Anomalía detectada en sector 7");
        bitacora.registrar("Escudos al 40%");
        bitacora.registrar("ERROR CRÍTICO: fallo en sistema de navegación");

        // 2. Consultar último
        System.out.println("SISTEMA: Último registro -> " + bitacora.consultarUltimo());

        // 3. Protocolo de revisión por ERROR
        if (bitacora.consultarUltimo().contains("ERROR")) {
            System.out.println("\nIniciando limpieza de registros...");
            for (int i = 0; i < 3; i++) {
                if (!bitacora.estaVacia()) {
                    System.out.println("Removido: " + bitacora.eliminarUltimo());
                }
            }
        }

        // 4. Estado final
        System.out.println("\nEventos restantes: " + bitacora.totalEventos());
        System.out.println("Tope actual: " + bitacora.consultarUltimo());
    }
}
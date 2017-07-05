/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calses;

/**
 *
 * @author aquin
 */
public class Gato {

    private int[][] datos;
    private String jugador1;
    private String jugador2;
    private int tiroJ1;                     // 1= "X", 2="O"
    private int tiroJ2;
    private boolean turnoJ1;                // true= le toca la jugador 1, false = jugador 2
    private int tiros;                      // Numero de tiros

    public Gato() {
        datos = new int[3][3];
        turnoJ1 = true;
        tiros = 0;
    }
    /**
     * MEtodos para depositar el nombre del jugador 1 y 2
     * @param jugador1 
     */
    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }
    /**
     * Metodo para calcular su posicion de un tiro
     * y depositar la posicion en el arreglo datos
     * @param pos 
     */
    public void setTiro(int pos) {
        int x;
        int y;
        x = pos / 3;         // calcular la fila
        y = pos % 3;        // calcular la columna
        if (turnoJ1) {
            datos[x][y] = tiroJ1;
        } else {
            datos[x][y] = tiroJ2;
        }
        System.out.println("tiro " + x + "," + y);
    }
    /**
     * Metodo para hacer un tiro
     * @param tiroJ1 
     */
    public void setTiroJ1(int tiroJ1) {
        this.tiroJ1 = tiroJ1;
        if (tiroJ1 == 1) {   // Tira X
            tiroJ2 = 2;    // Tira O
        } else {
            tiroJ2 = 1;
        }

    }
    /**
     * Metodo para cambiar el turno del jugador 
     * (una ves que se equivoque)
     */
    public void cambiarTurno() {
        if (turnoJ1) {
            turnoJ1 = false;
        } else {
            turnoJ1 = true;
        }
        tiros++;
    }

    public boolean isTurnoJ1() {
        return turnoJ1;
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    public int getTiroJ1() {
        return tiroJ1;
    }

    public int getTiroJ2() {
        return tiroJ2;
    }

    public int getTiros() {
        return tiros;
    }
    
    /**
     * Metodo para saber si un jugador ya gano
     * @return 
     */
    public int ganador() {
       // int win = 0;  // No hay ganador
        if (datos[0][0] != 0 && datos[0][0] == datos[0][1] && datos[0][0]
                == datos[0][2]) {
            return 1;   // ganador en fila #1
        }
        if (datos[1][0] != 0 && datos[1][0] == datos[1][1] && datos[1][0]
                == datos[1][2]) {
            return 2;   // ganador en fila #2
        }
        if (datos[2][0] != 0 && datos[2][0] == datos[2][1] && datos[2][0]
                == datos[2][2]) {
            return 3;   // ganador en la fila 3
        }
        if (datos[0][0] != 0 && datos[0][0] == datos[1][0] && datos[0][0]
                == datos[2][0]) {
            return 4;   // ganador en la columna #1
        }
        if (datos[0][1] != 0 && datos[0][1] == datos[1][1] && datos[0][1]
                == datos[2][1]) {
            return 5;   // ganador en la columna #2
        }
        if (datos[0][2] != 0 && datos[0][2] == datos[1][2] && datos[0][2]
                == datos[2][2]) {
            return 6;   // ganador en la columna #3
        }
        if (datos[0][0] != 0 && datos[0][0] == datos[1][1] && datos[0][0]
                == datos[2][2]) {
            return 7;   // ganador en diagonal #1
        }
        if (datos[0][2] != 0 && datos[0][2] == datos[1][1] && datos[0][2]
                == datos[2][0]) {
            return 8;   // ganador en diagonal #2
        }
        return 0;       // no hay ganador aun 
    }
    
    /**
     * Metodo para saber si nadie de los
     * dos jgadores gano y se declara un empate 
     * @return 
     */
    public boolean esEmpate() {
        if (ganador() == 0 && tiros == 9) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Metodo para reiniciar el tablero y borrar las imagenes del tablero
     * y borrar tambien los datos jenerados por el juego
     */
    public void reiniciar(){
        for(int i=0;i<3;i++){
            for(int j = 0; j < 3; j++){
                datos[i][j] = 0;
            }
        }
        tiros=0;
        turnoJ1=true;
    }
    
    
    
}// Fin clase

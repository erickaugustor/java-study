package studyEs.thread.DominandoOMonstro;

public class ProcessoDoTipo1 extends Thread {

    private boolean vivo = true;

    //public ProcessoDoTipo1 (Fila<Sting> x){
    // this.f1 = x;
    //}

    public void morra(){ this.vivo = false; }

    public void run() {
        while (this.vivo) {
            int nro = (int) (Math.random() * 1000) + 1;
            boolean cheia;

            synchronized {
                cheia = this.f1.cheia();
            }

            if (cheia)
                this.yield(); //esse método faz abrir mão do tempo de execução que ela ainda tem
            else {
                synchronized (this.f1){
                    this.f1.guarde("" + nro); //" para virar String
                }
            }
        }
    }
}

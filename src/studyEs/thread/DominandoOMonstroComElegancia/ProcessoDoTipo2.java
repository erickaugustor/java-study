package studyEs.thread.DominandoOMonstroComElegancia;

public class ProcessoDoTipo2 extends Thread {

    public ProcessoDoTipo2 (Fila<String> x){
        this.f2 = x;
    }

    private boolean vivo = true;

    public void morra(){ this.vivo = false; }

    public void run(){
        while(this.vivo){
            if(this.f2.vazia())
                this.yield();
            else{
                System.out.println(this.f2.getUmItem());
                this.f2.jogueForaUmItem();
            }
        }
    }
}

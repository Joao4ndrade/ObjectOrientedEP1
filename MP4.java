import java.util.List;

public class MP4 {
    String nome;
    String artista;
    String localizacao;
    double preco;
    public MP4( String n, String a, String l,double p){
        this.nome = n;
        this.artista = a;
        this.localizacao = l;
        this.preco =p;
    }
    public void insereMP4(String nome,String artista,String localizacao,double preço){
    }
    public String toString(){
        return "Nome: "+this.nome+", Artista: " + this.artista+", Localizacao: " + this.localizacao+ ", Preco: "+ this.preco;
    }
    public void eliminaMP4(String nome, String artista){}
    public void listaEmOrdemDeNome() throws AcervoVazioException {}
    public void listaEmOrdemDeArtista() throws AcervoVazioException{}
    public List listaMusicasDeArtista(String artista) throws AcervoVazioException{ return null;}
    public void selecionaAleatorioMusica() throws AcervoVazioException{}
    public void selecionaAleatorioMusica(String artista) throws AcervoVazioException{}


}

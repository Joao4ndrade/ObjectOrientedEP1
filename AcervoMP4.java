import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
import java.util.Map;

public class AcervoMP4 extends MP4{
    public AcervoMP4(String n, String a, String l, double p) {
        super(n, a, l, p);
    }
    static List <MP4> c1 = new ArrayList<>();


    public String toString(){
        return "Nome: "+this.nome+", Artista:" + this.artista+", Localizacao" + this.localizacao+ ", Preco"+ this.preco;
    }

    public static <E> void swap(List<E> a, int i, int j) {
        E tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    public static void shuffle(List<?> list, Random rnd) {
        for (int i = list.size(); i > 1; i--)
            swap(list, i - 1, rnd.nextInt(i));
    }

    @Override
    public void insereMP4(String nome, String artista, String localizacao, double preco) {
        if(nome.length() > 35 || localizacao.length() > 125){
            System.out.println("registro não inserido");
        }
        else c1.add(new MP4(nome,artista,localizacao,preco));
        System.out.println("registro inserido");
    }
    @Override
    public void eliminaMP4(String nome, String artista){

        for (Iterator<MP4> it = c1.iterator(); it.hasNext();){
            MP4 mp = it.next();
            if(mp.artista.equals(artista) && mp.nome.equals(nome)) {
                it.remove();
                System.out.println("Registro eliminado");
            }

            }
    }
    @Override
    public void listaEmOrdemDeNome() throws AcervoVazioException{
        if (c1.isEmpty()){
            throw new AcervoVazioException("Acervo de MP4 vazio");
        }
        Map<String, Double> m = new TreeMap<>();
        for (Iterator<MP4> it = c1.iterator(); it.hasNext();){
            MP4 mp = it.next();
            m.put("Nome: "+mp.nome +"| Artista: "+ mp.artista +"| Localizacao "+ mp.localizacao, mp.preco);
        }
        for (var entry : m.entrySet()) {
            System.out.println(entry.getKey() + "| Preco: " + entry.getValue());
        }
    }
    @Override
    public void listaEmOrdemDeArtista() throws AcervoVazioException{
        if (c1.isEmpty()){
            throw new AcervoVazioException("Acervo de MP4 vazio");
        }
        Map<String, Double> m = new TreeMap<>();
        for (Iterator<MP4> it = c1.iterator(); it.hasNext();){
            MP4 mp = it.next();
            m.put("Artista: "+mp.artista +"| Nome:"+ mp.nome +"| Localizacao: "+ mp.localizacao+" ", mp.preco);
        }
        for (var entry : m.entrySet()) {
            System.out.println(entry.getKey() + "| Preco: " + entry.getValue());
        }
    }
    @Override
    public List listaMusicasDeArtista(String artista) throws AcervoVazioException{
        if (c1.isEmpty()){
            throw new AcervoVazioException("Acervo de MP4 vazio");
        }
        List<MP4> c2 = new ArrayList<>();
        for (Iterator<MP4> it = c1.iterator(); it.hasNext();) {
            MP4 mp = it.next();
            if(artista.equals(mp.artista))
                c2.add(mp);
        }
        if(c2.isEmpty()) {
            throw new AcervoVazioException("Acervo de MP4 vazio");
        }
        else
            for( MP4 c : c2)
                System.out.println(c);;
    return c2;
    }
    @Override
    public void selecionaAleatorioMusica() throws AcervoVazioException{
        if (c1.isEmpty()){
            throw new AcervoVazioException("Acervo de MP4 vazio");
        }
        shuffle( c1 , new Random(c1.size()));
        Iterator<MP4> it = c1.iterator();
        System.out.println(it.next());
    }
    @Override
    public void selecionaAleatorioMusica(String artista) throws AcervoVazioException{
        if (c1.isEmpty()){
            throw new AcervoVazioException("Acervo de MP4 vazio");
        }
        List<MP4> c3 = new ArrayList<>();
        for (Iterator<MP4> it = c1.iterator(); it.hasNext();) {
            MP4 mp = it.next();

          if(artista.equals(mp.artista))
              c3.add(mp);
        }
        shuffle(c3, new Random(c3.size()));
        Iterator<MP4> it2 = c3.iterator();
        System.out.println(it2.next());
    }



    public static void main(String[] args) {

        MP4 a2 = new AcervoMP4("","","",0);


        a2.insereMP4("Rocketman","Elton John","1",30);
        a2.insereMP4("Get Lucky","Daft Punk","2",30);
        a2.insereMP4("Redemption Song","Bob Marley","3",30);
        a2.insereMP4("Um Minuto","Exaltasamba","4",30);
        a2.insereMP4("Short Circuit","Daft Punk","5",30);
        a2.insereMP4("Touch","Daft Punk","6",30);
        a2.insereMP4("Fragments of Time","Daft Punk","7",30);
        a2.insereMP4("Satisfy my Soul","Bob Marley","8",30);
        a2.insereMP4("Falta Voce","Thiaguinho","9",30);

        try {
            a2.selecionaAleatorioMusica();
            a2.selecionaAleatorioMusica("Daft Punk");
            a2.eliminaMP4("Rocketman","Elton John");
            a2.eliminaMP4("Get Lucky","Daft Punk");
            a2.eliminaMP4("Redemption Song","Bob Marley");

            a2.eliminaMP4("Um Minuto","Exaltasamba");
            a2.listaMusicasDeArtista("Daft Punk");
            a2.listaEmOrdemDeNome();
            a2.listaEmOrdemDeArtista();

        } catch (AcervoVazioException erro){
            System.out.println(erro.getMessage());
        }

    }
}

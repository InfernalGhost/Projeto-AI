package

imports

@Document("musics")

public class Music {
    @Id
    private String name;

    public Music(Strin name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
package

imports

@Repository
public interface MusicRepository extends MongoRepository<Music,String> {
    @Query("{name: ?0}")
    Music findByMusicName(String name);
}
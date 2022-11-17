package fc;

abstract class Support {
    Movie movie;
    
    public Support(Movie m){
        movie = m;
    }

    public Movie getMovie(){
        return movie;
    }
}

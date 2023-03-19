import org.json.JSONArray;
import org.json.JSONObject;

public class RequestResolver implements SearchByAuthor,SearchByWork,SearchByISBN{


    private String result;
    private String request;
    RequestResolver(String request, String type){
        this.request = request;
        if(type.equals("isbn")){
            searchIsbn();
        }
    }

    public String getResult(){
        return result;
    }

    @Override
    public String searchAuthor() {
        return null;
    }

    @Override
    public void searchIsbn() {
        JSONObject isbnResult = new JSONObject(new OpenLibraryCommunicator(Constants.LIBRARY+Constants.ISBN+request+Constants.JSON).find());
        int arrL = isbnResult.getJSONArray("authors").length();
        String author = String.valueOf(isbnResult.getJSONArray("authors"));
        JSONArray work = isbnResult.getJSONArray("works");
        result = author+" "+work;
    }

    @Override
    public String searchWork() {
        return null;
    }
}

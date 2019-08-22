package robotcommunication.betterlifethanksapp.gmail.com.retofitappMVP.retofitReqresIn;

import robotcommunication.betterlifethanksapp.gmail.com.retofitappMVP.MainContract;
import robotcommunication.betterlifethanksapp.gmail.com.retofitappMVP.retofitReqresIn.pojo.User;
import robotcommunication.betterlifethanksapp.gmail.com.retofitappMVP.retrofit.APIClient;

public class SiteOperationFabric implements MainContract.SiteOperationInterceptor{

    private final APIInterface mInterface;
    private final String SITE_NAME = "https://reqres.in";
    private final SiteOperations siteOperations;
    private final ResourceHelpers resourceHelpers;

    public SiteOperationFabric() {
        mInterface =APIClient.getClient(SITE_NAME).create(APIInterface.class);
        siteOperations = new SiteOperations(mInterface);
        resourceHelpers = new ResourceHelpers();
    }
    @Override
    public void getListResources(final MainContract.SiteOperationInterceptor.OnFinishedListener listener)
    {
        siteOperations.getListResources(listener,resourceHelpers);
    }
    @Override
    public void createNewUser(final MainContract.SiteOperationInterceptor.OnFinishedListener listener)
    {
        User user = new User("morpheus", "leader");
        siteOperations.createNewUser(listener,resourceHelpers,user);
    }
    @Override
    public void getListUser(final MainContract.SiteOperationInterceptor.OnFinishedListener listener,String numPage)
    {
        siteOperations.getListUser(listener,resourceHelpers,numPage);
    }

}

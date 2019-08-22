package robotcommunication.betterlifethanksapp.gmail.com.retofitappMVP;

public class MainPresenter implements MainContract.Presenter,MainContract.SiteOperationInterceptor.OnFinishedListener {


    private MainContract.View mainView;
    private MainContract.SiteOperationInterceptor siteOperationInterceptor;

    MainPresenter(MainContract.View mainView, MainContract.SiteOperationInterceptor siteOperationInterceptor) {
        this.mainView = mainView;
        this.siteOperationInterceptor = siteOperationInterceptor;
    }

    @Override
    public void createUser() {
        mainView.showProgress();
        siteOperationInterceptor.createNewUser(this);
    }

    @Override
    public void createListResources() {
        mainView.showProgress();
        siteOperationInterceptor.getListResources(this);
    }

    @Override
    public void createUserList() {
        mainView.showProgress();
        String numPage = "2";
        siteOperationInterceptor.getListUser(this,numPage);
    }

    @Override
    public void clearScreen() {
        mainView.clearText();
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onFinishText(String message) {
            mainView.hideProgress();
            mainView.showText(message);
    }

    @Override
    public void onFinishToast(String message) {
        mainView.hideProgress();
        mainView.showToast(message);
    }
}

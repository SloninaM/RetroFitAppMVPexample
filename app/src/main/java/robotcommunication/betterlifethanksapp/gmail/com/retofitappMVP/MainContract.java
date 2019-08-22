package robotcommunication.betterlifethanksapp.gmail.com.retofitappMVP;

public interface MainContract {

    interface View{
        void clearText();
        void showToast(String message);
        void showText(String message);
        void showProgress();
        void hideProgress();
    }

    interface Presenter{
        void createUser();
        void createListResources();
        void createUserList();
        void clearScreen();
        void onDestroy();
    }


    interface SiteOperationInterceptor{
        interface OnFinishedListener
        {
            void onFinishText(String message);
            void onFinishToast(String message);
        }

        void getListResources(final MainContract.SiteOperationInterceptor.OnFinishedListener listener);
        void createNewUser(final MainContract.SiteOperationInterceptor.OnFinishedListener listener);
        void getListUser(final MainContract.SiteOperationInterceptor.OnFinishedListener listener,String numPage);

    }

}

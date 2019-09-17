package questionary.module.main.router;

import questionary.models.User;
import questionary.module.test.view.TestViewImpl;

public class MainRouterImpl implements MainRouter {

    @Override
    public void goToTest(User user) {
        TestViewImpl test = new TestViewImpl();
        test.start(user);
    }
}

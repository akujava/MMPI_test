package questionary.module.main.router;

import questionary.Sex;
import questionary.module.test.view.TestViewImpl;

public class MainRouterImpl implements MainRouter {

    @Override
    public void goToTest(Sex sex) {
        TestViewImpl test = new TestViewImpl();
        test.start(sex);
    }
}

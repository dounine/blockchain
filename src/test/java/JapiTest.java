import com.dounine.japi.JapiClient;
import com.dounine.japi.JapiClientStorage;
import com.dounine.japi.JapiClientTransfer;
import com.dounine.japi.core.IProject;
import com.dounine.japi.core.impl.ProjectImpl;
import org.junit.Test;

import java.net.URL;

/**
 * Created by lake on 17-4-21.
 */
public class JapiTest {

    @Test
    public void tesCreate() {
        JapiClient.setClassLoader(JapiTest.class);
        JapiClient.setPrefixPath("/home/lake/github/");//路径前缀
        JapiClient.setpostfixPath("/src/main/java");
        JapiClient.setProjectJavaPath("blockchain");//主项目位置
        JapiClient.setActionReletivePath("com/dounine/blockchain/action");//主项目action位置
        JapiClient.saveHistory(true);//保留本地历史版本
        JapiClient.setFlushServer(false);//强制同步本地与服务器所有版本
        JapiClient.delete(false);
//        JapiClient.setIncludeProjectJavaPath(new String[]{//关联项目
//                "demo/demo-card/demo-card-api",
//                "common/common-api"
//        });
        JapiClient.setIncludePackages(new String[]{"com.dounine.blockchain"});//可以准确快速搜索
        IProject project = ProjectImpl.init();
        JapiClientStorage japiClientStorage = JapiClientStorage.getInstance();
        japiClientStorage.setProject(project);
        japiClientStorage.autoSaveToDisk();
        new JapiClientTransfer().autoTransfer(japiClientStorage);
    }
}

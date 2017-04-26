import com.dounine.blockchain.core.BlockInfo;
import com.dounine.blockchain.core.Storage;
import com.dounine.blockchain.core.impl.BlockBuildImpl;
import com.dounine.blockchain.core.impl.BlockInfoImpl;
import com.dounine.blockchain.core.impl.DiskStorage;
import com.dounine.blockchain.core.impl.ElementImpl;
import com.dounine.blockchain.exception.BlockException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Base64;

/**
 * Created by lake on 17-4-21.
 */
public class BlockTest {

    /**
     * 测试保存
     */
    @Test
    public void testCreate() throws BlockException {
        BlockInfoImpl blockInfo = new BlockInfoImpl();
        blockInfo.setAuthor("lake");
        blockInfo.setCreateTime(LocalDateTime.now());
        blockInfo.setHash(Hex.encodeHexString(DigestUtils.sha1("lake2")));

        BlockBuildImpl blockBuild = new BlockBuildImpl();
        blockBuild.setStorage(new DiskStorage());
        blockBuild.create(blockInfo);
    }

    @Test
    public void testPush() throws BlockException {
        BlockBuildImpl blockBuild = new BlockBuildImpl();
        blockBuild.setStorage(new DiskStorage());

        ElementImpl element = new ElementImpl();
        element.setAuthor("lake");
        element.setContent("这是我的密码");
        element.setCreateTime(LocalDateTime.now());

        blockBuild.push("41be905ed2febef70dcc1bac29f7eb97d7e5746d",element);
    }
}

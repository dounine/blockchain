package com.dounine.blockchain.core.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONWriter;
import com.dounine.blockchain.core.BlockInfo;
import com.dounine.blockchain.core.Element;
import com.dounine.blockchain.core.Storage;
import com.dounine.blockchain.exception.BlockException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lake on 17-4-21.
 */
public class DiskStorage implements Storage {
    private static String blockchainFoldPath = null;

    static {
        String userPath = FileUtils.getUserDirectoryPath();
        userPath += "/blockchain";
        File blockchainFold = new File(userPath);
        if (!blockchainFold.exists()) {
            blockchainFold.mkdir();
        }
        blockchainFoldPath = blockchainFold.getPath();
    }

    private static final IOFileFilter ioFileFilter = new IOFileFilter() {
        @Override
        public boolean accept(File file) {
            return file.isFile()&&file.getName().matches("\\d+");
        }

        @Override
        public boolean accept(File dir, String name) {
            return false;
        }
    };
    private void writeObjectToDisk(String saveFilePath,Object object) throws IOException {
        File blockInfoFile = new File(saveFilePath);
        Writer writer = new FileWriter(blockInfoFile);
        JSONWriter jsonWriter = new JSONWriter(writer);
        jsonWriter.startObject();
        jsonWriter.writeObject(object);
        jsonWriter.endObject();
        jsonWriter.close();
        writer.close();
    }

    @Override
    public void saveBlock(BlockInfo blockInfo) throws BlockException {
        if(StringUtils.isBlank(blockInfo.getHash())){
            throw new BlockException("block hash 不能为空");
        }
        String blockPath = blockchainFoldPath + "/" + blockInfo.getHash();
        File file = new File(blockPath);
        if (!file.exists()) {
            file.mkdir();
        }else{
            throw new BlockException(blockInfo.getHash()+" 区块已经存在.");
        }
        try {
            writeObjectToDisk(file.getPath() + "/block",blockInfo);
            new File(file.getPath()+"/elements").mkdir();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pushElement(String blockId, Element element) throws BlockException{
        String blockPath = blockchainFoldPath + "/" + blockId;
        File file = new File(blockPath);
        if(!file.exists()){
            throw new BlockException(blockId+" 区块不存在");
        }
        File elementFile = getBlockElementTopFile(new File(file.getAbsoluteFile()+"/elements"));
        int fileNameHeight = 1;
        if(null!=elementFile){
            fileNameHeight = (new Integer(elementFile.getName()) + 1);
        }
        String elementPath = blockPath+"/elements/"+fileNameHeight;
        try {
            writeObjectToDisk(elementPath,element);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BlockInfo> list() {
        return null;
    }

    private File getBlockElementTopFile(File blockFile){
        try {
            Collection<File> files = FileUtils.listFiles(blockFile, ioFileFilter, null);
            if (files.size() >= 1) {
                if (files.size() > 1) {
                    files = files.stream().sorted((b, a) -> {//排序，取区块中高度最高的元素
                        return new Integer(a.getName()).compareTo(new Integer(b.getName()));
                    }).collect(Collectors.toList());
                    return files.iterator().next();
                }else{
                    return files.iterator().next();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }
}

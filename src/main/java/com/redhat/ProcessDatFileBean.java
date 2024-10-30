package com.redhat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessDatFileBean {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessDatFileBean.class);

    private Part uploadedFile; // +getter+setter

    private File savedFile;

    private List<UploadedImage> files = new ArrayList<>();

    private String displayMessage;

    private boolean uploadSuccessful = false;

    private List<String> errors = null;

    public int getSize() {

        return getFiles().size();
    }

    public void paint(OutputStream stream, Object object) throws IOException {

        stream.write(getFiles().get((Integer) object).getData());
    }

    public void uploadFile() {

        LOG.info("{}", uploadedFile.getName());
        LOG.info("{}", uploadedFile.getSubmittedFileName());
        LOG.info("{}", uploadedFile.getContentType());
        LOG.info("{}", uploadedFile.getSize());

        byte[] data = null;
        try {
            InputStream is = uploadedFile.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] inData = new byte[4];

            while ((nRead = is.read(inData, 0, inData.length)) != -1) {
                buffer.write(inData, 0, nRead);
            }

            buffer.flush();
            data = buffer.toByteArray();
        } catch (IOException ex) {
            LOG.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }

        UploadedImage file = new UploadedImage();
        file.setLength(data.length);
        file.setName(uploadedFile.getName());
        file.setData(data);
        files.add(file);

        uploadSuccessful = true;
    }

    public String clearUploadData() {

        files.clear();
        return null;
    }

    public Part getUploadedFile() {

        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {

        this.uploadedFile = uploadedFile;
    }

    public List<UploadedImage> getFiles() {

        LOG.info("getFiles() {}", files != null ? files.size() : null);

        return files;
    }

    public void setFiles(List<UploadedImage> files) {

        LOG.info("setFiles() {}", files != null ? files.size() : null);

        this.files = files;
    }

    public String getDisplayMessage() {

        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {

        this.displayMessage = displayMessage;
    }

    public boolean isUploadSuccessful() {

        return uploadSuccessful;
    }

    public void setUploadSuccessful(boolean uploadSuccessful) {

        this.uploadSuccessful = uploadSuccessful;
    }

    public List<String> getErrors() {

        return errors;
    }

    public void setErrors(ArrayList<String> errors) {

        this.errors = errors;
    }

}
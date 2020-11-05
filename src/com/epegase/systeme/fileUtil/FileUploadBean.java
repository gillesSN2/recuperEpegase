package com.epegase.systeme.fileUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

public class FileUploadBean {
   private ArrayList files = new ArrayList();
   private int uploadsAvailable = 20;
   private boolean autoUpload = false;
   private boolean useFlash = false;

   public int getSize() {
      return this.getFiles().size() > 0 ? this.getFiles().size() : 0;
   }

   public void paint(OutputStream var1, Object var2) throws IOException {
      var1.write(((OwnerFile)this.getFiles().get((Integer)var2)).getData());
   }

   public void listener(UploadEvent var1) throws Exception {
      UploadItem var2 = var1.getUploadItem();
      OwnerFile var3 = new OwnerFile();
      var3.setLength((long)var2.getData().length);
      var3.setName(var2.getFileName());
      var3.setData(var2.getData());
      this.files.add(var3);
      --this.uploadsAvailable;
      System.out.println("La taille de ma liste " + this.getSize());
   }

   public String clearUploadData() {
      this.files.clear();
      this.setUploadsAvailable(5);
      return null;
   }

   public long getTimeStamp() {
      return System.currentTimeMillis();
   }

   public ArrayList getFiles() {
      return this.files;
   }

   public void setFiles(ArrayList var1) {
      this.files = var1;
   }

   public int getUploadsAvailable() {
      return this.uploadsAvailable;
   }

   public void setUploadsAvailable(int var1) {
      this.uploadsAvailable = var1;
   }

   public boolean isAutoUpload() {
      return this.autoUpload;
   }

   public void setAutoUpload(boolean var1) {
      this.autoUpload = var1;
   }

   public boolean isUseFlash() {
      return this.useFlash;
   }

   public void setUseFlash(boolean var1) {
      this.useFlash = var1;
   }
}

package com.epegase.systeme.xml;



import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.xml.ObjetFamilleTiers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class LectureTauxCnamgs implements Serializable {
  private long strId;
  
  private Structure structureLog;
  
  private ObjetFamilleTiers objetFamilleTiers;
  
  private List<ObjetFamilleTiers> mesTauxCnamgs = new ArrayList<ObjetFamilleTiers>();
  
  private List<SelectItem> mesTauxCnamgsItems;
  
  public List<SelectItem> chargerMesTauxCnamgsItems() throws JDOMException, IOException {
    try {
      SAXBuilder sAXBuilder = new SAXBuilder();
      Document document = null;
      FileReader fileReader = null;
      File file = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "medical" + File.separator + "configuration" + File.separator + "tauxCnamgs.xml");
      if (!file.exists()) {
        file = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "medical" + File.separator + "configuration" + File.separator + "tauxCnamgs.xml");
        fileReader = new FileReader(file);
        document = sAXBuilder.build(fileReader);
        enregistreFmtClient(document);
      } else {
        fileReader = new FileReader(file);
        document = sAXBuilder.build(fileReader);
      } 
      Element element = document.getRootElement();
      this.mesTauxCnamgs = new ArrayList<ObjetFamilleTiers>();
      this.mesTauxCnamgsItems = new ArrayList<SelectItem>();
      List<Element> list = element.getChildren();
      for (byte b = 0; b < list.size(); b++) {
        this.objetFamilleTiers = new ObjetFamilleTiers();
        String str1 = ((Element)list.get(b)).getChild("libelle").getText();
        String str2 = ((Element)list.get(b)).getChild("tauxCmangs").getText();
        this.objetFamilleTiers.setIndice(b);
        this.objetFamilleTiers.setLibelle(str1);
        if (str2 != null && !str2.isEmpty()) {
          this.objetFamilleTiers.setTauxCnamgs(Integer.parseInt(str2));
        } else {
          this.objetFamilleTiers.setTauxCnamgs(0);
        } 
        this.mesTauxCnamgs.add(this.objetFamilleTiers);
        this.mesTauxCnamgsItems.add(new SelectItem(Integer.valueOf(this.objetFamilleTiers.getTauxCnamgs()), this.objetFamilleTiers.getLibelle()));
      } 
      fileReader.close();
    } catch (JDOMException jDOMException) {
    
    } catch (IOException iOException) {}
    return this.mesTauxCnamgsItems;
  }
  
  public void enregistreFmtClient(Document paramDocument) throws FileNotFoundException, IOException {
    XMLOutputter xMLOutputter = new XMLOutputter(Format.getPrettyFormat());
    FileOutputStream fileOutputStream = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "medical" + File.separator + "configuration" + File.separator + "tauxCnamgs.xml");
    xMLOutputter.output(paramDocument, fileOutputStream);
    fileOutputStream.close();
  }
  
  public List<ObjetFamilleTiers> getMesTauxCnamgs() {
    return this.mesTauxCnamgs;
  }
  
  public void setMesTauxCnamgs(List<ObjetFamilleTiers> paramList) {
    this.mesTauxCnamgs = paramList;
  }
  
  public List<SelectItem> getMesTauxCnamgsItems() {
    return this.mesTauxCnamgsItems;
  }
  
  public void setMesTauxCnamgsItems(List<SelectItem> paramList) {
    this.mesTauxCnamgsItems = paramList;
  }
  
  public long getStrId() {
    return this.strId;
  }
  
  public void setStrId(long paramLong) {
    this.strId = paramLong;
  }
  
  public Structure getStructureLog() {
    return this.structureLog;
  }
  
  public void setStructureLog(Structure paramStructure) {
    this.structureLog = paramStructure;
  }
}

import service.ManagementService;
import service.impl.ManagementServiceImpl;

public class Main {
    public static void main(String[] args) {
        /*
        1-ci Buy Coin seçildikdə istifadəçi istədiyi coini və istədiyi miqdarda (Maximum 10 olmaq şerti ile ) ala bilər.
        Diger terefde ise digər clientler (Threadler) her 5 saniyeden bir random coini random miqdarda(max 10 olmaq şərti ilə ) alacaqdir.
        Bİz hər bir cliente başlanğıc olaraq 30 000 azn mebleginde balans vereceyik və bu balansla istifadəçilər coin alacaqdır.
        (qeyd: eger client yalniz balansı çatdığı qeder coin ala və sata bilər bunu nezere alin
        her bir client mutleq şekilde 5 saniyeden bir hansisa coini almalidir balans yetersizdir deyib coin almasin 5 saniye daha gozlesin
         deye bir seçim OLMASIN!!! və 1 bit coin almaga balanasi çatırsa onu alsın ve oyunu qazansın) İstifadeçi 5 saniyeden 1 coin ala biiler
         ama satmaq hissesinde ise limit yoxdur istediyi zaman istediyi qeder coini sata biler . BU zaman clientin hesabindan hemin
         coinler silinmelidir !)

         Her client ucun elave hashMap yaratmaq lazimdir!
         */
        ManagementService managementService = new ManagementServiceImpl();
        managementService.manageClient();
        managementService.manageBuyByOtherAutomatedClients();
        managementService.manageSellByOtherAutomatedClients();
        managementService.shutdownExecutorService();

    }
}
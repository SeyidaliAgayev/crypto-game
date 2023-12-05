import data.GlobalData;
import model.Client;
import service.CryptoService;
import service.ExecutorManagementService;
import service.ManagementService;
import service.impl.CryptoServiceImpl;
import service.impl.ExecutorManagementServiceImpl;
import service.impl.ManagementServiceImpl;


public class Main {
    public static void main(String[] args) {

        ManagementService managementService = new ManagementServiceImpl();
        ExecutorManagementService executorManagementService = new ExecutorManagementServiceImpl();
        managementService.manageClient();
        executorManagementService.executorManagement();



    }
}
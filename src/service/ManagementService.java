package service;

public interface ManagementService {
    void manageClient();
    void manageBuyByOtherAutomatedClients();
    void manageSellByOtherAutomatedClients();
    void shutdownExecutorService();

}

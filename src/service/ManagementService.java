package service;

import model.Client;

public interface ManagementService {
    void manageClient();
    Thread manageOtherClients();
}

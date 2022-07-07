package knap.jakub.itemsManagement.service;

import knap.jakub.itemsManagement.model.AppUser;

public interface AppUserService {

    AppUser registerUser(AppUser user);

    boolean userExist(String username);

}

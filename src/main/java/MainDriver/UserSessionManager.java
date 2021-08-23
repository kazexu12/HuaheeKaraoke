/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainDriver;

import DTO.UserDTO;

/**
 *
 * @author ASUS
 */
public class UserSessionManager {
    static UserDTO logonUser;

public static boolean login(UserDTO u) {
	logonUser = u;
        return true;
}

public static boolean logout() {
	logonUser = null;
        return true;
}

public static UserDTO getLogonUser() {
	return UserSessionManager.logonUser;
}
}

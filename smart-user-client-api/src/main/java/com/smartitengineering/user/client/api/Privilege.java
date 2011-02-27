/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartitengineering.user.client.api;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author modhu7
 */
public interface Privilege extends Serializable {

  public String getName();

  public String getDisplayName();

  public String getShortDescription();

  public SecuredObject getSecuredObject();

  public Integer getPermissionMask();

  public Date getLastModifiedDate();

  public void setName(String name);

  public void setDisplayName(String displayName);

  public void setShortDescription(String shortDescription);

  public void setSecuredObject(SecuredObject securedObject);

  public void setPermissionMask(Integer permissionMask);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartitengineering.user.client.api;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author modhu7
 */
public interface UserGroup extends Serializable {

  public String getName();

  public void setName(String name);

  public Date getLastModifiedDate();

  public void setLastModifiedDate(Date lastModifiedDate);
}

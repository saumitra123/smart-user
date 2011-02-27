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
public interface Organization extends Serializable {

  public String getName();

  public String getUniqueShortName();

  public Address getAddress();

  public Date getLastModifiedDate();

  public Date getCreationDate();

  public void setName(String name);

  public void setUniqueShortName(String uniqueShortName);

  public void setAddress(Address address);
}

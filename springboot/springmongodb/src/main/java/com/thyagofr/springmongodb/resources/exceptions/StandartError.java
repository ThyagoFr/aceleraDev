package com.thyagofr.springmongodb.resources.exceptions;

import java.io.Serializable;

public class StandartError implements Serializable{

  private static final long serialVersionUID = 1L;
  private Long timestamp;
  private String path;
  private int status;
  private String error;
  private String message;

  public StandartError() {
  }

  public StandartError(Long timestamp, int status, String error, String message, String path) {
    this.timestamp = timestamp;
    this.path = path;
    this.status = status;
    this.error = error;
    this.message = message;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
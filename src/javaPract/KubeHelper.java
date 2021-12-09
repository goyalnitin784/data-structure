package javaPract;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

public class KubeHelper {

  public static void main(String[] args) throws Exception {
    RandomAccessFile randomAccessFile = new RandomAccessFile(
        "/home/nitin/nitin.goyal/kubedata/deployment_final.json", "rw");
    String test = null;
    String finalOutput = "";
    while ((test = randomAccessFile.readLine()) != null) {
      finalOutput += test;
    }

    JsonArray deployments = new JsonParser().parse(finalOutput).getAsJsonObject().get("items")
        .getAsJsonArray();
    Map<String, DataModel> finalData = new HashMap<>();
    for (int i = 0; i < deployments.size(); i++) {
      DataModel dataModel = new DataModel();
      JsonArray containers = deployments.get(i).getAsJsonObject().get("spec").getAsJsonObject()
          .get("template").getAsJsonObject().get("spec").getAsJsonObject().get("containers")
          .getAsJsonArray();
      dataModel.setReplica(
          deployments.get(i).getAsJsonObject().get("spec").getAsJsonObject().get("replicas")
              .getAsInt());
      int cpuRequest = 0;
      int cpuLimit = 0;
      int memoryRequest = 0;
      int memoryLimit = 0;
      for (int c = 0; c < containers.size(); c++) {
        JsonObject resources = containers.get(c).getAsJsonObject().get("resources")
            .getAsJsonObject();
        if (!resources.has("requests")) {
          dataModel.setMemoryRequest("NA");
          dataModel.setCpuRequest("NA");
        } else {
          JsonObject requests = resources.get("requests").getAsJsonObject();
          if (requests.has("memory")) {
            String memRequestsString = requests.get("memory").getAsString();
            if (memRequestsString.endsWith("G") || memRequestsString.endsWith("g")) {
              memoryRequest =
                  Integer.valueOf(memRequestsString.substring(0, memRequestsString.length() - 1))
                      * 1000;
            } else if (memRequestsString.endsWith("Gi") || memRequestsString.endsWith("gi")) {
              memoryRequest =
                  Integer.valueOf(memRequestsString.substring(0, memRequestsString.length() - 2))
                      * 1000;
            } else if (memRequestsString.endsWith("m") || memRequestsString.endsWith("M")) {
              memoryRequest = Integer
                  .valueOf(memRequestsString.substring(0, memRequestsString.length() - 1));
            }
          } else {
            dataModel.setMemoryRequest("NA");
          }
          if (requests.has("cpu")) {
            if (requests.get("cpu").getAsString().endsWith("m")) {
              cpuRequest += Integer
                  .parseInt(requests.get("cpu").getAsString().replace("m", ""));
            } else {
              cpuRequest += Integer.parseInt(requests.get("cpu").getAsString()) * 1000;
            }

          } else {
            dataModel.setCpuRequest("NA");
          }

        }

        if (!resources.has("limits")) {
          dataModel.setCpuLimit("NA");
          dataModel.setMemoryLimit("NA");
        } else {
          JsonObject limits = resources.get("limits").getAsJsonObject();
          if (limits.has("memory")) {
            String memortLimitString = limits.get("memory").getAsString();
            if (memortLimitString.endsWith("G") || memortLimitString.endsWith("g")) {
              memoryLimit =
                  Integer.valueOf(memortLimitString.substring(0, memortLimitString.length() - 1))
                      * 1000;
            } else if (memortLimitString.endsWith("Gi") || memortLimitString.endsWith("gi")) {
              memoryLimit =
                  Integer.valueOf(memortLimitString.substring(0, memortLimitString.length() - 2))
                      * 1000;
            } else if (memortLimitString.endsWith("m") || memortLimitString.endsWith("M")) {
              memoryLimit = Integer
                  .valueOf(memortLimitString.substring(0, memortLimitString.length() - 1));
            }
          } else {
            dataModel.setMemoryLimit("NA");
          }
          if (limits.has("cpu")) {
            if (limits.get("cpu").getAsString().endsWith("m")) {
              cpuLimit += Integer
                  .parseInt(limits.get("cpu").getAsString().replace("m", ""));
            } else {
              cpuLimit += Integer
                  .parseInt(limits.get("cpu").getAsString()) * 1000;
            }

          } else {
            dataModel.setCpuLimit("NA");
          }
        }

      }
      dataModel.setCpuLimit(String.valueOf(cpuLimit));
      dataModel.setCpuRequest(String.valueOf(cpuRequest));
      dataModel.setMemoryRequest(String.valueOf(memoryRequest));
      dataModel.setMemoryLimit(String.valueOf(memoryLimit));
      finalData.put(
          deployments.get(i).getAsJsonObject().get("metadata").getAsJsonObject().get("namespace")
              .getAsString() + ":" + deployments.get(i).getAsJsonObject().get("metadata")
              .getAsJsonObject().get("name")
              .getAsString(), dataModel);
    }
    System.out.println("");
  }

}

class DataModel {

  int replica;
  String cpuRequest;
  String cpuLimit;
  String memoryRequest;
  String memoryLimit;

  public int getReplica() {
    return replica;
  }

  public void setReplica(int replica) {
    this.replica = replica;
  }

  public String getCpuRequest() {
    return cpuRequest;
  }

  public void setCpuRequest(String cpuRequest) {
    this.cpuRequest = cpuRequest;
  }

  public String getCpuLimit() {
    return cpuLimit;
  }

  public void setCpuLimit(String cpuLimit) {
    this.cpuLimit = cpuLimit;
  }

  public String getMemoryRequest() {
    return memoryRequest;
  }

  public void setMemoryRequest(String memoryRequest) {
    this.memoryRequest = memoryRequest;
  }

  public String getMemoryLimit() {
    return memoryLimit;
  }

  public void setMemoryLimit(String memoryLimit) {
    this.memoryLimit = memoryLimit;
  }
}

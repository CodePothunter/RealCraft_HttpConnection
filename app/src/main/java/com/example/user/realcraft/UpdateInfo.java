package com.example.user.realcraft;

import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2015/6/4.
 */
public class UpdateInfo {
    public void updateBuild(int id, double latitude, double longitude){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        String Id = Integer.toString(id);
        String Latitude = Double.toString(latitude);
        String Longitude = Double.toString(longitude);
        String location = Latitude+','+Longitude;
        params.add(new BasicNameValuePair("targetId", Id));
        params.add(new BasicNameValuePair("selflocation", location));
        String response = HttpUtil.HttpClientPOST("http://112.74.98.74/operation/build",params);
        int res = -64;
        try {
            res = Integer.parseInt(response);
        } catch (Exception e){
            res = -64;
        }
        switch (res){
            case -64:
                Log.d("SHOW","�����������쳣");
            case -1:
                Log.d("SHOW","��½�쳣");
                break;
            case -2:
                Log.d("SHOW","Ŀ��̫Զ");break;
            case -3:
                Log.d("SHOW", "��Դ����");break;
            default:;
                String Progress = "�������"+Integer.toString(res)+"%";
                Log.d("SHOW",Progress);
        }
    }
    public void updateAttack(int id, double latitude, double longitude){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        String Id = Integer.toString(id);
        String Latitude = Double.toString(latitude);
        String Longitude = Double.toString(longitude);
        String location = Latitude+','+Longitude;
        params.add(new BasicNameValuePair("targetId", Id));
        params.add(new BasicNameValuePair("selflocation", location));
        String response = HttpUtil.HttpClientPOST("http://112.74.98.74/operation/attack",params);
        int res = -64;
        try {
            res = Integer.parseInt(response);
        } catch (Exception e){
            res = -64;
        }
        switch (res){
            case -64:
                Log.d("SHOW","�����������쳣");
            case -1:
                Log.d("SHOW","��½�쳣");
                break;
            case -2:
                Log.d("SHOW","Ŀ��̫Զ");break;
            default:;
                String Progress = "�;ö�"+Integer.toString(res)+"%";
                Log.d("SHOW",Progress);
        }
    }
    public void updateCollect(int id, double latitude, double longitude){
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        String Id = Integer.toString(id);
        String Latitude = Double.toString(latitude);
        String Longtitude = Double.toString(longitude);
        String location = Latitude+','+Longtitude;
        params.add(new BasicNameValuePair("targetId", Id));
        params.add(new BasicNameValuePair("selflocation", location));
        String response = HttpUtil.HttpClientPOST("http://112.74.98.74/operation/collect",params);
        int res = -64;
        try {
            res = Integer.parseInt(response);
        } catch (Exception e){
            res = -64;
        }
        switch (res){
            case -64:
                Log.d("SHOW","�����������쳣");break;
            case 0:
                Log.d("SHOW","�ɼ�ʧ��");break;
            case -1:
                Log.d("SHOW","��½�쳣");break;
            case -2:
                Log.d("SHOW","�ɼ��ص����");break;
            default:;
                String Progress = "�ɼ��˳ɹ�";
                Log.d("SHOW",Progress);
        }
    }

    private List<String> convertStringToJSONFirstTime(String source){
        List<String> pairs = new ArrayList<String>();
        String playerInfo = "empty";
        String resourceInfo = "empty";
        String constructorInfo = "empty";
        int i = 0;
        String[] sourceArray = source.split("/");
        try {
            playerInfo = "[" + sourceArray[0] + "]";
        } catch(Exception e){
            Log.d("Test", "�û���Ϣ��ȡʧ��");
        }
        try{
            resourceInfo  = "["+sourceArray[1].substring(1);
            for(i = 2; i < sourceArray.length ;++i){
                if(!sourceArray[i].substring(0,1).equals("1"))break;
                resourceInfo = ","+sourceArray[i].substring(1);
            }
            resourceInfo = resourceInfo + "]";
        } catch (Exception e){
            Log.d("Test","��ȡ��Դʧ��");
        }
        try{
            constructorInfo = "[" + sourceArray[i].substring(1);
            for(;i<sourceArray.length;++i){
                constructorInfo = ","+sourceArray[i].substring(1);
            }
            constructorInfo = constructorInfo+"]";
        } catch (Exception e){
            Log.d("Test","��ȡ������ʧ��");
        }
        pairs.add(playerInfo);
        pairs.add(resourceInfo);
        pairs.add(constructorInfo);
        return pairs;
    }

    public void analyseAllPointsFirstTime(List<String> sourceArray){

        String playerInfo = sourceArray.get(0);
        String resourceInfo = sourceArray.get(1);
        String constructorInfo = sourceArray.get(2);
        String id = null, location = null;
        String playId = null, playWood = null, playStone = null, playFood = null, playWorkForce = null;
        List<Pair<String,String>> resourceArray = new ArrayList<>();
        List<Pair<String,String>> constructorArray = new ArrayList<>();
        //��ȡ�û���Ϣ
        try{
            JSONArray jsonArray = new JSONArray(playerInfo);
            for(int i = 0; i < jsonArray.length(); ++i){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                playId = jsonObject.getString("playerId");
                playWood = jsonObject.getString("wood");
                playStone = jsonObject.getString("stone");
                playFood = jsonObject.getString("food");
                playWorkForce = jsonObject.getString("workforce");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        //��ȡ��Դ�����ɻ����Դ��λ�ú�id
        try{
            JSONArray jsonArray = new JSONArray(resourceInfo);
            for(int i = 0; i < jsonArray.length(); ++i) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                id = jsonObject.getString("id");
                location = jsonObject.getString("location");
                Pair<String,String> tmp = new Pair<String,String>(id,location);
                resourceArray.add(tmp);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        //��ȡ��������ɻ����Դ��λ�ú�id
        try{
            JSONArray jsonArray = new JSONArray(resourceInfo);
            for(int i = 0; i < jsonArray.length(); ++i) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                id = jsonObject.getString("id");
                location = jsonObject.getString("location");
                Pair<String,String> tmp = new Pair<String,String>(id,location);
                constructorArray.add(tmp);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

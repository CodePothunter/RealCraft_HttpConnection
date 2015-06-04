package com.example.user.realcraft;

import android.util.Log;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

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
}

#include <OneWire.h>
#include <DallasTemperature.h>
#include <Javino.h>

Javino j;
int LDR = 3;
int SOLO = A0;
int RELE = 11;
int TEMP = 5;
int PH = A1;
float calibration = 28.4; //change this value to calibrate
int sensorValue = 0;
unsigned long int avgValue;
float b;
int buf[10],temp;
OneWire ourWire(TEMP); //CONFIGURA UMA INSTÂNCIA ONEWIRE PARA SE COMUNICAR COM O SENSOR
DallasTemperature sensors(&ourWire); //BIBLIOTECA DallasTemperature UTILIZA A OneWire


void setup() {
  Serial.begin(9600);
  pinMode(RELE, OUTPUT);
  pinMode(SOLO, INPUT);
  pinMode(LDR, INPUT);
  pinMode(TEMP, INPUT);
  sensors.begin();

}

void loop() {
  String parametros = "";
  String luzValor = "";
  String umidadeValor = "";
  String tempValor = "";
  String phValor = "";
  digitalWrite(RELE, HIGH);
  if(j.availablemsg()){
    String msg = j.getmsg();
    if(msg=="getPercepts"){
        tempValor = getTemp();
        luzValor = getLuz();
        phValor = getPh();
        umidadeValor = getUmidade();
        j.sendmsg("light("+luzValor+");humidity("+umidadeValor+");temperature("+tempValor+");pH("+phValor+");");
    }
    if(msg=="on"){
        digitalWrite(RELE, LOW);
    }
    if(msg=="off"){
        digitalWrite(RELE, HIGH);
    }
  }
}

String getLuz(){
  String msg = "";
  if(digitalRead(LDR) == HIGH){
    msg = "noLight";
  }
  else{
    msg = "withLight";
  }
  return msg;
}

String getUmidade(){
  String msg = "";
  int umidade = analogRead(SOLO);
  if (umidade > 400) msg = "dry";
  if (umidade < 400 && umidade > 300) msg = "wet";
  if (umidade < 300) msg = "ideal";
  return msg;
}

String getTemp(){
  String msg = "";
  sensors.requestTemperatures();
  msg = sensors.getTempCByIndex(0);
  return msg;
}

String getPh(){
 String msg = "";
 for(int i=0;i<10;i++)
 {
 buf[i]=analogRead(PH);
 delay(30);
 }
 for(int i=0;i<9;i++)
 {
 for(int j=i+1;j<10;j++)
 {
 if(buf[i]>buf[j])
 {
 temp=buf[i];
 buf[i]=buf[j];
 buf[j]=temp;
 }
 }
 }
 avgValue=0;
 for(int i=2;i<8;i++)
 avgValue+=buf[i];
 float pHVol=(float)avgValue*5.0/1024/6;
 float phValue = -5.70 * pHVol + calibration;
 msg = phValue;
 delay(500);
 return msg;
}


function bilgileriDoldur(dosyaNumarasi){
    let adEditField = document.getElementById("adEdit");
    let soyadEditField = document.getElementById("soyadEdit");
    let hastaTcField = document.getElementById("tcEdit");
    let raporTarihField = document.getElementById("raporTarihEdit");
    let taniBasligiField = document.getElementById("taniBasligiEdit");
    let taniDetaylariField = document.getElementById("taniDetaylariEdit");
    let dosyaNoField = document.getElementById("dosyaEdit");
    let form = document.getElementById("formId")
    fetch('http://localhost:8080/tekHasta/'+dosyaNumarasi)
        .then((response)=>response.json())
        .then((data)=>{
            dosyaNoField.value = data.dosyaNo;
            adEditField.value=data.hastaAdi;
            soyadEditField.value = data.hastaSoyadi;
            hastaTcField.value = data.hastaTC;
            raporTarihField.value = data.raporTarih.substring(0,10);
            taniBasligiField.value = data.taniBasligi;
            taniDetaylariField.value = data.taniDetaylari;
            form.action='/update/'+data.dosyaNo;

        });}


let dosyaNoArama = document.getElementById("dosyaNoArama");
let searchFields = document.querySelector(".modal-body-search")

function aramaYap(){
    let arananDeger = dosyaNoArama.value;
    let adArama = document.getElementById("adEditArama")
    let soyadArama = document.getElementById("soyadEditArama")
    let tcArama = document.getElementById("tcEditArama")
    let raporTarihArama = document.getElementById("raporTarihEditArama")
    let taniBasligiArama = document.getElementById("taniBasligiEditArama")
    let textArea=document.getElementById("textarea")
    searchFields.style.visibility='visible'
    if(arananDeger!=""){
    fetch('http://localhost:8080/tekHasta/'+arananDeger)
        .then((response)=>response.json())
        .then((data)=>{
            if(data){
            adArama.value=data.hastaAdi;
            soyadArama.value=data.hastaSoyadi;
            tcArama.value=data.hastaTC;
            raporTarihArama.value=data.raporTarih.substring(0,10);
            taniBasligiArama.value=data.taniBasligi;
            textArea.value=data.taniDetaylari;
            }
            else{
                alert("Girdiğiniz dosya numarasına ait bir veri bulunamadı.")
            }

        })
    }
    else{
        alert("DOSYA NO GİRİNİZ")
    }
}

let aramaButon = document.getElementById("aramaYap");
aramaButon.addEventListener("click",aramaYap);

let detaylarButon = document.querySelector(".detaylarButton")

detaylarButon.addEventListener("click",function(){
    alert("Detayları görebilmek için arama butonundan dosya numaranızı giriniz.")
})


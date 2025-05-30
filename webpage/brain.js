function API_COMPACT(){
    let originalURL = document.getElementById("originalURL").value
}

function API_DECOMPACT(){
    let compactURL = document.getElementById("compactURL").value
    ChangeURL(compactURL)
}

function ChangeURL(newURL){
    let finalURL = document.getElementById("finalURL")
    baseURL = ""
    if(!newURL.includes("https")){
        baseURL += "https://"
    }
    if(!newURL.includes("www")){
        baseURL += "www."
    }
    finalURL.innerHTML = baseURL + newURL
    finalURL.href = baseURL + newURL
}
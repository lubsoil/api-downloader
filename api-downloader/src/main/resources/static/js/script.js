function sendRequestToDownload(){
    results = fetch("/api/posts/download", { method: "GET" }).then((response) => {
        if(response.status == 200){
            const result = document.getElementById("result");
            result.innerHTML = "Posts have been downloaded properly";
            result.style.color = "green";
        }else{
            const result = document.getElementById("result");
            result.innerHTML = "Downloading posts failed";
            result.style.color = "red";
        }
    });
}
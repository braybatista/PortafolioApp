import { Component, OnInit} from '@angular/core';
import { Observable } from 'rxjs';
import { Portafolio } from 'src/app/Models/Portafolio';
import { FileUploadService } from 'src/app/Services/file-upload.service';
import { PortafolioService } from 'src/app/Services/portafolio.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  portafolio: Portafolio = new Portafolio();
  urlImagen = '';
  tweets: any[] = [];

  file!: File;

  images: any[] = [];

  fileInfos?: Observable<any>;

  constructor(private service: PortafolioService, private fileUploadService: FileUploadService){
    console.log("constructor");
  }

  ngOnInit(): void {
    console.log("ngOnInit");

    this.service.getPortafolio().subscribe(data => {
      if(data != null && data.length > 0){
        this.portafolio = data[0];
        this.fileUploadService.getFile2(this.portafolio.id).subscribe(response => {
          this.images = response != undefined ? response : "";
          this.urlImagen = response != undefined ? response[0] : "../../../assets/image.png";
        });
      } else{
        this.portafolio.id = 1;
      }
    });
  }

  setUrlImg(){
    this.urlImagen = "../../../assets/image.png";  
  }

  saveProfile(portafolio: Portafolio){
    this.service.addEditPortafolio(portafolio).subscribe(data=>{
      this.onUpload();
      alert("informacion actualizada correctamente");
      setTimeout(function(){
        window.location.reload();
      }, 500)
      
    });
  }

	onUpload() {
		this.fileUploadService.upload(this.file, this.portafolio.id).subscribe(response =>{
      console.log(response)
      this.file = {} as File;
    }
			// (event: any) => {
			// 	if (typeof (event) === 'object') {
      //     console.log(event)
      //     //this.saveProfile(this.portafolio);
      //     this.file = {} as File;
			// 	}
			// }
		);
	}

  // On file Select
	onChange(event: any) {
		this.file = event.target.files[0];
	}
}

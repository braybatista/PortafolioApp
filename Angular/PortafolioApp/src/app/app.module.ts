import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './Components/App/app.component';

import { PortafolioService } from './Services/portafolio.service';
import { TwitterService } from './Services/twitter-service.service';
import { TweetsComponent } from './Components/tweets/tweets.component';
import { FileUploadService } from './Services/file-upload.service';

@NgModule({
  declarations: [
    AppComponent,
    TweetsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    PortafolioService,
    TwitterService,
    FileUploadService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

//configuracion defirebase2
import { AngularFireModule } from 'angularfire2';
import { environment } from '../environments/environment';
import { AngularFirestoreModule } from 'angularfire2/firestore';
import { AngularFireStorageModule } from 'angularfire2/storage';
import { AngularFireAuthModule, AngularFireAuth } from 'angularfire2/auth';
//rutas
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';


//
import { ViewComponent } from './view/view.component';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AddComponent } from './add/add.component'; 
import { LoginComponent } from './login/login.component';
//
import { ConexionService } from './services/conexion.service';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';


export const routes: Routes = [
  {path:'', component: LoginComponent, pathMatch: 'full'},
  {path: 'view', component: ViewComponent},
  {path: 'add', component: AddComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    ViewComponent,
    AddComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    //configuracion defirebase2
    AngularFireModule.initializeApp(environment.firebase),
    AngularFirestoreModule,
    AngularFireAuthModule,
    AngularFireStorageModule,
    //para las rutas
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

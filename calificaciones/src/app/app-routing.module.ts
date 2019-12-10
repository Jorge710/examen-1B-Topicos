import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
//
//import { Routes, RouterModule } from '@angular/router';
//import { LoginComponent } from './auth/login/login.component';
import { RegistrationComponent } from './auth/registration/registration.component';
import { HomeComponent } from './home/home.component';
import { ViewComponent } from './view/view.component';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { AddComponent } from './add/add.component'; 
import { LoginComponent } from './auth/login/login.component';

const routes: Routes = [

  //{path:'', component: LoginComponent, pathMatch: 'full'},
  //{path: 'view', component: ViewComponent},
  //{path: 'add', component: AddComponent},
  //{path: 'login', component: LoginComponent},
  //{path: 'registration', component: RegistrationComponent},
  {
    path: 'login',
    component: LoginComponent  
  },
  {
    path: 'register',
    component: RegistrationComponent
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  }
];


@NgModule({
 
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]

})
export class AppRoutingModule { }





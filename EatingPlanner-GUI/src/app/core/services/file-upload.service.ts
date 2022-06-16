import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FileUploadService {

  private baseFileUploadUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  upload(file: File, recipeName: string): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();
    formData.append('file', file);
    formData.append('recipeImageRequest', recipeName)
    const req = new HttpRequest('POST', `${this.baseFileUploadUrl}/upload`, formData, {
      reportProgress: true,
      responseType: 'json'
    });
    return this.http.request(req);
  }

  getFiles(): Observable<any> {
    return this.http.get(`${this.baseFileUploadUrl}/files`);
  }

  getFile(fileName: string): Observable<any> {
    return this.http.get(`${this.baseFileUploadUrl}/files/${fileName}`, {responseType: 'blob'})
  }
}

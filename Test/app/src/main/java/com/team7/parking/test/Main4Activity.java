package com.team7.parking.test;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main4Activity extends AppCompatActivity {
    private final int CAMERA_REQUEST = 1888;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

        finish();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            //StorageReference mStorageRef;
            //mStorageRef = FirebaseStorage.getInstance().getReference();

            //ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //photo.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            //byte[] data1 = baos.toByteArray();

            //UploadTask uploadTask = mStorageRef.putBytes(data1);
            //uploadTask.addOnFailureListener(new OnFailureListener() {
            //@Override
            // public void onFailure(@NonNull Exception exception) {
            // Handle unsuccessful uploads
            // }
            //}).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            // @Override
            //public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
            // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
            //Uri downloadUrl = taskSnapshot.getDownloadUrl();
            //}
            //});
        }
    }
}

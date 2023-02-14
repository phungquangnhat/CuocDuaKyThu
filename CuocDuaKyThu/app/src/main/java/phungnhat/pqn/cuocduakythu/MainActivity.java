package phungnhat.pqn.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageButton btnPlay;
    TextView txtDiem;
    CheckBox cb1, cb2, cb3;
    SeekBar sb1, sb2, sb3;
    final int MIN = 0;
    final int MAX = 5;
    int diem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);
        btnPlay.setVisibility(View.VISIBLE);
        CountDown();
    }

    private void CountDown() {
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    cb2.setChecked(false);
                    cb1.setChecked(false);
                }
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sb1.setProgress(0);
                sb2.setProgress(0);
                sb3.setProgress(0);
                Random random = new Random();
                diem = Integer.parseInt(txtDiem.getText().toString());
                if (cb1.isChecked()|| cb2.isChecked()||cb3.isChecked()){
                    btnPlay.setVisibility(View.INVISIBLE);
                    DisableCheckBox();
                    CountDownTimer countDownTimer = new CountDownTimer(20000, 300) {
                        @Override
                        public void onTick(long l) {
                            int pg1 = sb1.getProgress();
                            int pg2 = sb2.getProgress();
                            int pg3 = sb3.getProgress();
                            int rd = random.nextInt(MAX - MIN + 1) + MIN;
                            int rd1 = random.nextInt(MAX - MIN + 1) + MIN;
                            int rd2 = random.nextInt(MAX - MIN + 1) + MIN;
                            sb1.setProgress(pg1 + rd);
                            sb2.setProgress(pg2 + rd1);
                            sb3.setProgress(pg3 + rd2);
//                            sb1.setProgress(pg1 + rd);
//                            sb2.setProgress(pg2 + rd);
//                            sb3.setProgress(pg3 + rd1);
                            Log.d("AAA", "rd1 "+ rd);
                            if (sb1.getProgress() >= 100 || sb2.getProgress() >= 100 || sb3.getProgress() >= 100){
                                this.cancel();
                                if (sb1.getProgress() >= 100 && sb2.getProgress() < 100 && sb3.getProgress() < 100){
                                    Toast.makeText(MainActivity.this, "one win!", Toast.LENGTH_SHORT).show();
                                    if (cb1.isChecked()){
                                        Toast.makeText(MainActivity.this, "You win!", Toast.LENGTH_SHORT).show();
                                        diem += 10;
                                        txtDiem.setText(diem + "");
                                    }
                                    else {
                                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!", Toast.LENGTH_SHORT).show();
                                        DiemTru();
                                    }
                                }
                                else if (sb2.getProgress() >= 100 && sb1.getProgress() < 100 && sb3.getProgress() < 100){
                                    Toast.makeText(MainActivity.this, "two win!", Toast.LENGTH_SHORT).show();
                                    if (cb2.isChecked()){
                                        Toast.makeText(MainActivity.this, "You win!", Toast.LENGTH_SHORT).show();
                                        diem += 10;
                                        txtDiem.setText(diem + "");
                                    }
                                    else {
                                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!", Toast.LENGTH_SHORT).show();
                                        DiemTru();
                                    }
                                }
                                else if (sb3.getProgress() >= 100 && sb1.getProgress() < 100 && sb2.getProgress() < 100){
                                    Toast.makeText(MainActivity.this, "three win!", Toast.LENGTH_SHORT).show();
                                    if (cb3.isChecked()){
                                        Toast.makeText(MainActivity.this, "You win!", Toast.LENGTH_SHORT).show();
                                        diem += 10;
                                        txtDiem.setText(diem + "");
                                    }
                                    else {
                                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!", Toast.LENGTH_SHORT).show();
                                        DiemTru();
                                    }
                                }
                                else if (sb3.getProgress() >= 100 && sb1.getProgress() >= 100 && sb2.getProgress() < 100)
                                {
                                    Toast.makeText(MainActivity.this, "one and three win!", Toast.LENGTH_SHORT).show();
                                    if (cb3.isChecked()){
                                        Toast.makeText(MainActivity.this, "You win!", Toast.LENGTH_SHORT).show();
                                        diem += 10;
                                        txtDiem.setText(diem + "");
                                    }
                                    else if (cb1.isChecked()){
                                        Toast.makeText(MainActivity.this, "You win!", Toast.LENGTH_SHORT).show();
                                        diem += 10;
                                        txtDiem.setText(diem + "");
                                    }
                                    else {
                                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!", Toast.LENGTH_SHORT).show();
                                        DiemTru();
                                    }
                                }
                                else if (sb1.getProgress() >= 100 && sb2.getProgress() >= 100 && sb3.getProgress() < 100)
                                {
                                    Toast.makeText(MainActivity.this, "one and three win!", Toast.LENGTH_SHORT).show();
                                    if (cb1.isChecked()){
                                        Toast.makeText(MainActivity.this, "You win!", Toast.LENGTH_SHORT).show();
                                        diem += 10;
                                        txtDiem.setText(diem + "");
                                    }
                                    else if (cb2.isChecked()){
                                        Toast.makeText(MainActivity.this, "You win!", Toast.LENGTH_SHORT).show();
                                        diem += 10;
                                        txtDiem.setText(diem + "");
                                    }
                                    else {
                                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!", Toast.LENGTH_SHORT).show();
                                        DiemTru();
                                    }
                                }
                                else if (sb3.getProgress() >= 100 && sb2.getProgress() >= 100 && sb1.getProgress() < 100)
                                {
                                    Toast.makeText(MainActivity.this, "one and three win!", Toast.LENGTH_SHORT).show();
                                    if (cb3.isChecked()){
                                        Toast.makeText(MainActivity.this, "You win!", Toast.LENGTH_SHORT).show();
                                        diem += 10;
                                        txtDiem.setText(diem + "");
                                    }
                                    else if (cb2.isChecked()){
                                        Toast.makeText(MainActivity.this, "You win!", Toast.LENGTH_SHORT).show();
                                        diem += 10;
                                        txtDiem.setText(diem + "");
                                    }
                                    else {
                                        Toast.makeText(MainActivity.this, "Bạn đoán sai rồi!", Toast.LENGTH_SHORT).show();
                                        DiemTru();
                                    }
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "All win", Toast.LENGTH_SHORT).show();
                                    diem += 10;
                                    txtDiem.setText(diem + "");
                                }
                                btnPlay.setVisibility(View.VISIBLE);
                                EnableCheckBox();
                            }
                        }

                        @Override
                        public void onFinish() {
                        }
                    }.start();
                }
                else {
                    Toast.makeText(MainActivity.this, "Vui lòng đặt cược trước!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void DiemTru(){
        if (diem == 10){
            txtDiem.setText(0 + "");
            Toast.makeText(this, "Game over!", Toast.LENGTH_SHORT).show();
            diem = 100;
            txtDiem.setText(diem + "");
        }
        else{
            diem -= 10;
            txtDiem.setText(diem + "");
        }
    }
    private void EnableCheckBox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }
    private void DisableCheckBox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
    private void AnhXa() {
        btnPlay = findViewById(R.id.btnPlay);
        txtDiem = findViewById(R.id.txtDiem);
        cb1     = findViewById(R.id.ck1);
        cb2     = findViewById(R.id.ck2);
        cb3     = findViewById(R.id.ck3);
        sb1     = findViewById(R.id.sb1);
        sb2     = findViewById(R.id.sb2);
        sb3     = findViewById(R.id.sb3);
    }
}
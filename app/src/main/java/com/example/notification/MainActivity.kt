package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val builder1 = getNotificationBuilder("channel1", "첫 번째 채널")

            //작은 아이콘(메시지 수신시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰 아이콘(메시지 본문에 표시할 메시지, Bitmap 객체
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            //숫자 설정
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 1")
            //메시지 설정
            builder1.setContentText("Content Text 1")

            //메시지 객체를 생성한다.
            val notification = builder1.build()

            //알림 메시지를 관리하는 객체를 추출한다.
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(10, notification)
        }

        binding.button2.setOnClickListener {
            val builder1 = getNotificationBuilder("channel1", "첫 번째 채널")

            //작은 아이콘(메시지 수신시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰 아이콘(메시지 본문에 표시할 메시지, Bitmap 객체
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            //숫자 설정
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 2")
            //메시지 설정
            builder1.setContentText("Content Text 2")

            //메시지 객체를 생성한다.
            val notification = builder1.build()

            //알림 메시지를 관리하는 객체를 추출한다.
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(20, notification)
        }

        binding.button3.setOnClickListener {
            val builder1 = getNotificationBuilder("channel2", "두 번째 채널")

            //작은 아이콘(메시지 수신시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰 아이콘(메시지 본문에 표시할 메시지, Bitmap 객체
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            //숫자 설정
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 3")
            //메시지 설정
            builder1.setContentText("Content Text 3")

            //메시지 객체를 생성한다.
            val notification = builder1.build()

            //알림 메시지를 관리하는 객체를 추출한다.
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(30, notification)
        }

        binding.button4.setOnClickListener {
            val builder1 = getNotificationBuilder("channel2", "두 번째 채널")

            //작은 아이콘(메시지 수신시 상단에 보여줄 작은 아이콘)
            builder1.setSmallIcon(android.R.drawable.ic_menu_search)
            //큰 아이콘(메시지 본문에 표시할 메시지, Bitmap 객체
            val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
            builder1.setLargeIcon(bitmap)
            //숫자 설정
            builder1.setNumber(100)
            //타이틀 설정
            builder1.setContentTitle("Content Title 4")
            //메시지 설정
            builder1.setContentText("Content Text 4")

            //메시지 객체를 생성한다.
            val notification = builder1.build()

            //알림 메시지를 관리하는 객체를 추출한다.
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(40, notification)
        }
    }

    //안드로이 8.0 이상과 미만 버전에 대응하기 위해 채널을 설정하는 메서드
    fun getNotificationBuilder(id:String, name:String) : NotificationCompat.Builder {
        //OS버전별로 분기
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            //알림 메시지를 관리하는 객체를 추출한다.
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            //채널 객체를 생성한다.
            //채널 id를 NotificationCompat에 지정해 준다.
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH)
            //메시지 출력시 단말기  LED를 사용할 것인ㄱ다?
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)

            //알림 메시지를 관리하는 객체에 채널을 등록한다.
            manager.createNotificationChannel(channel)

            val builder = NotificationCompat.Builder(this, id)
            return builder
        } else {
            val builder = NotificationCompat.Builder(this)
            return builder
        }
    }
}